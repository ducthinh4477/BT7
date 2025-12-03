package vn.iotstar.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import vn.iotstar.entity.Video;
import vn.iotstar.entity.Category;
import vn.iotstar.service.VideoService;
import vn.iotstar.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/admin/videos")
public class VideoController {

    @Autowired
    VideoService videoService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Video> videos = videoService.findAll();
        model.addAttribute("videos", videos);
        return "admin/video/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("video", new Video());
        model.addAttribute("categories", categoryService.findAll());
        return "admin/video/form";
    }

    @PostMapping("/save")
    public String save(Video video) {
        videoService.save(video);
        return "redirect:/admin/videos/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Video video = videoService.findById(id).orElse(null);
        model.addAttribute("video", video);
        model.addAttribute("categories", categoryService.findAll());
        return "admin/video/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        videoService.deleteById(id);
        return "redirect:/admin/videos/list";
    }
}
