package com.cloud.auth.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cloud.auth.entity.ClientDetails;
import com.cloud.auth.service.ClientDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * ClientDetailsController控制层
 * </p>
 *
 * @Title: ClientDetailsController.java
 * @Package: com.cloud.auth.controller;
 * @Author <a href="mailto:au_t@qq.com"">au.T</a>
 * @Date: 2019-04-06 16:52:22
 * @Version: 1.0.0
 */
@RestController
@AllArgsConstructor
@RequestMapping("clientDetails")
public class ClientDetailsController {
    private final ClientDetailsService clientDetailsService;

    /**
     * 简单分页查询
     *
     * @param page          分页对象
     * @param clientDetails
     * @return
     */
    @GetMapping("/page")
    public Object getClientDetailsPage(Page<ClientDetails> page, ClientDetails clientDetails) {
        return (clientDetailsService.page(page,
                Wrappers.<ClientDetails>query().lambda()
        ));
    }


    /**
     * 通过id查询单条记录
     *
     * @param clientId
     * @return ResponseEntity
     */
    @GetMapping("/{clientId}")
    public Object getById(@PathVariable("clientId") String clientId) {
        return (clientDetailsService.getById(clientId));
    }

    /**
     * 新增记录
     *
     * @param clientDetails
     * @return ResponseEntity
     */
    //@SysLogAnnotation("新增")
    @PostMapping
    public Object save(@RequestBody ClientDetails clientDetails) {
        return (clientDetailsService.save(clientDetails));
    }

    /**
     * 修改记录
     *
     * @param clientDetails
     * @return ResponseEntity
     */
    //@SysLogAnnotation("修改")
    @PutMapping
    public Object update(@RequestBody ClientDetails clientDetails) {
        return (clientDetailsService.updateById(clientDetails));
    }

    /**
     * 通过id删除一条记录
     *
     * @param clientId
     * @return ResponseEntity
     */
    //@SysLogAnnotation("删除")
    @DeleteMapping("/{clientId}")
    public Object removeById(@PathVariable String clientId) {
        return (clientDetailsService.removeById(clientId));
    }
}