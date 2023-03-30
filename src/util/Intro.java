package util;

public class Intro {
    public static void pageIntro() {
        String[] intro = {"""
                      
                                       / ======= \\
                                      / __________\\
                                     | ___________ |
                                     | | -       | |
                                     | |         | |
                                     | |_________| |_______________________________
                                     \\=____________/   Customer Trading System     )
                                     / ""\"""\"""\""" \\                           /
                                    / ::::::::::::: \\                  
                                   (_________________)"""};

        System.out.print("\033[H\033[2J");

        for (String line : intro) {
            System.out.println(line);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.print("\033[H\033[2J");
    }
}
