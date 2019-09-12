package com.qul.controller;


import com.qul.pageresult.PageResult;
import com.qul.pojo.Brand;
import com.qul.result.Result;
import com.qul.service.BrandService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/brand")
public class BrankController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/findAll")
    @ResponseBody
    public PageResult findAll(){
        return brandService.findAll();
    }
    @RequestMapping("/findOne")
    @ResponseBody
    public Brand findOne(long id){
        return brandService.findOne(id);
    }
    @RequestMapping("/save")
    @ResponseBody
    public Result save(@RequestBody Brand brand){
        try {
            brandService.save(brand);
            return new Result(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败");
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Brand brand){
        try {
            brandService.update(brand);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }
    @RequestMapping("/del")
    @ResponseBody
    public Result del(long[] ids){
        try {
            brandService.del(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"删除失败");
        }
    }
    @RequestMapping("/search")
    @ResponseBody
    public PageResult search(@RequestBody Brand brand, @Param("page") String page, @Param("size")String size){
        return brandService.search(brand,page,size);
    }
}
