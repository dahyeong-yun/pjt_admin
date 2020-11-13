package org.cheatsheet.admin.domain.menu.entity;

import lombok.Getter;
import org.cheatsheet.admin.domain.menu.api.SystemMenuApi;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
public class SystemMenu {

    @Id @GeneratedValue
    @Column(name = "menuId")
    private Long id;

    @Column(name = "menuName")
    private String name;

    @Column(name = "menuUrl")
    private String url;

    @Enumerated(EnumType.STRING)
    @Column(name = "menuUsage")
    private MenuUsage usage;

    // TODO 하위 메뉴 존재 여부
    // TODO 기본 열림 설정

    private LocalDateTime createdTime;;
    private LocalDateTime lastModifiedTime;


    private SystemMenu() {}

    public static SystemMenu createMenu(String menuName, String menuUrl, MenuUsage menuUsage) {
        SystemMenu systemMenu = new SystemMenu();

        systemMenu.name = menuName;
        systemMenu.url = menuUrl;
        systemMenu.usage = menuUsage;
        systemMenu.createdTime = LocalDateTime.now();
        systemMenu.lastModifiedTime = LocalDateTime.now();

        return systemMenu;
    }

}
