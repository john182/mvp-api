package com.chronos.mvpapi.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

@Getter
@Setter
public class ResourceCreatEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private HttpServletResponse response;
    private String uuid;

    public ResourceCreatEvent(Object source, HttpServletResponse response, String uuid) {
        super(source);
        this.response = response;
        this.uuid = uuid;
    }


}