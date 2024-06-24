package com.inventarios.core;

import com.inventarios.handler.*;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath(value="mi")
public class App extends Application {
    public Set<Class<?>> getClasses(){
        HashSet classes=new HashSet();
        classes.add(AdminResource.class);
        classes.add(DataResource.class);
        classes.add(GreetingResource.class);
        classes.add(HelloResource.class);
        classes.add(UserResource.class);
        return classes;
    }
}