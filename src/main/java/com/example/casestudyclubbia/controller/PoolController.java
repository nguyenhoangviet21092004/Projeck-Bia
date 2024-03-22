package com.example.casestudyclubbia.controller;

import com.example.casestudyclubbia.model.Order;
import com.example.casestudyclubbia.model.PoolTable;
import com.example.casestudyclubbia.model.Room;
import com.example.casestudyclubbia.repository.IOrderRepo;
import com.example.casestudyclubbia.repository.IPoolRepo;
import com.example.casestudyclubbia.service.ipl.OrderService;
import com.example.casestudyclubbia.service.ipl.PoolTableService;
import com.example.casestudyclubbia.service.ipl.RoomService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.management.PlatformLoggingMXBean;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pools")
public class PoolController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private PoolTableService poolTableService;
    @Autowired
    private IPoolRepo iPoolRepo;
    @Autowired
    private OrderService orderService;
    @Autowired
    private IOrderRepo iOrderRepo;

    @GetMapping("")
    public String getPoolTable(Model model) {
        List<Room> listRoom = roomService.getAll();
        model.addAttribute("listRoom", listRoom);
        return "/pool";
    }

    @GetMapping("/view/{id}")
    public String viewRoom(@PathVariable String id, Pageable pageable, Model model, HttpServletRequest request) {
        Page<PoolTable> listTable = iPoolRepo.getAllById(Integer.parseInt(id), pageable);
        model.addAttribute("listTable", listTable);
        HttpSession session = request.getSession();
        session.setAttribute("listTable", listTable);
        return "/table";
    }

    @GetMapping("/order/{id}")
    public String orderTable(@PathVariable String id, Model model, HttpServletRequest request) {
        Optional<PoolTable> poolTable = poolTableService.findById(Integer.parseInt(id));
        HttpSession session = request.getSession();
        session.setAttribute("table", poolTable);

        Order order = new Order();
        order.setPoolTable(poolTable.get());

        model.addAttribute("order", order);

        return "/order";
    }

    @PostMapping("/order")
    public String order(@ModelAttribute Order order, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();

        int st1 = Integer.parseInt(order.getStartTime1());
        int st2 = Integer.parseInt(order.getStartTime2());
        int ed1 = Integer.parseInt(order.getEndTime1());
        int ed2 = Integer.parseInt(order.getEndTime2());

        LocalTime startTime1 = LocalTime.of(st1, ed1);
        LocalTime endTime1 = LocalTime.of(st2, ed2);

        Optional<PoolTable> poolTable = (Optional<PoolTable>) session.getAttribute("table");

        List<Order> orders = iOrderRepo.getAllOrder(poolTable.get().getId());

        for (Order order1 : orders) {
            LocalTime startTime2 = LocalTime.of(Integer.parseInt(order1.getStartTime1()), Integer.parseInt(order1.getEndTime1()));
            LocalTime endTime2 = LocalTime.of(Integer.parseInt(order1.getStartTime2()), Integer.parseInt(order1.getEndTime2()));

            boolean compare = endTime1.isAfter(startTime2) && endTime2.isAfter(startTime1);

            if (compare == true) {
                PoolTable poolTable1 = (PoolTable) session.getAttribute("table");

                Order ordered = new Order();
                order.setPoolTable(poolTable1);

                model.addAttribute("order", ordered);

                model.addAttribute("message", "Đã có người đặt ! Vui lòng chọn khoảng thời gian khác ");
                return "/order";
            }
        }

        orderService.save(order);

        Page<PoolTable> listTable = (Page<PoolTable>) session.getAttribute("listTable");
        model.addAttribute("listTable", listTable);
        return "/table";


    }

}
