package com.vmware.ensemble.rules.i18n;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.vmware.ensemble.rules.i18n.Accounts.Admin;
import com.vmware.ensemble.rules.i18n.Accounts.Member;
import com.vmware.ensemble.rules.i18n.Accounts.User;
import com.vmware.ensemble.rules.i18n.enums.City;
import com.vmware.ensemble.rules.i18n.model.Screen;
import com.vmware.ensemble.rules.i18n.model.Show;
import com.vmware.ensemble.rules.i18n.model.Theatre;

public class BookMyShow {

    public static void main(String[] args) throws Exception {
        System.out.println("--------------------------------BOOK MY SHOW-------------------------------------");

        Admin admin = new Admin("admin", "admin123", new User("admin", "admin", "xyz@gmail.com"));
        Member member = new Member("member", "member123", new User("member", "mayank", "s@gmail.com"));

        admin.login("admin", "admin123");
        member.login("member", "member123");
        init(admin);

        admin.addShowInTheTheatre("1", createShow());

        member.getMovieByCity(City.BANGALORE);
        member.getAllShow("1", City.BANGALORE);


    }

    private static Show createShow() {
       return new Show("1", "1", LocalDateTime.now(), LocalDateTime.now(), "1");
    }

    public static void init(Admin admin) {
        admin.addMovies("1","AVATAR", City.BANGALORE);
        admin.addMovies("2","DDLJ", City.BANGALORE);
        admin.addMovies("3", "DDLJ", City.PUNE);

        admin.addTheatre(createTheatre("1", City.BANGALORE));
        admin.addTheatre(createTheatre("2", City.PUNE));
    }

    public static Theatre createTheatre(String theatreId, City city) {
        Theatre inox = new Theatre(theatreId, city);
        inox.setScreen(createScreen());
        return inox;
    }

    private static List<Screen> createScreen() {
        List<Screen> screen = new ArrayList<>();

        Screen screen1 = new Screen("1", "Screen1", 10, 10, 10);
        Screen screen2 = new Screen("2", "Screen2", 10, 10, 10);
        Screen screen3 = new Screen("3", "Screen3", 10, 10, 10);

        screen.add(screen1);
        screen.add(screen2);
        screen.add(screen3);

        return screen;
    }
}