package org.example.abstract_factory;

public class FontStyleBulbhead implements FontStyle{
    @Override
    public void printStart() {
        System.out.println("\n" +
                " ___  ____   __    ____  ____ \n" +
                "/ __)(_  _) /__\\  (  _ \\(_  _)\n" +
                "\\__ \\  )(  /(__)\\  )   /  )(  \n" +
                "(___/ (__)(__)(__)(_)\\_) (__) \n");
    }

    @Override
    public void printGameOver() {
        System.out.println("\n" +
                "  ___    __    __  __  ____    _____  _  _  ____  ____ \n" +
                " / __)  /__\\  (  \\/  )( ___)  (  _  )( \\/ )( ___)(  _ \\\n" +
                "( (_-. /(__)\\  )    (  )__)    )(_)(  \\  /  )__)  )   /\n" +
                " \\___/(__)(__)(_/\\/\\_)(____)  (_____)  \\/  (____)(_)\\_)\n");
    }

    @Override
    public void printBall1() {
        System.out.println("\n" +
                " ____    __    __    __      __ \n" +
                "(  _ \\  /__\\  (  )  (  )    /  )\n" +
                " ) _ < /(__)\\  )(__  )(__    )( \n" +
                "(____/(__)(__)(____)(____)  (__)\n");
    }

    @Override
    public void printBall2() {
        System.out.println("\n" +
                " ____    __    __    __      ___  \n" +
                "(  _ \\  /__\\  (  )  (  )    (__ \\ \n" +
                " ) _ < /(__)\\  )(__  )(__    / _/ \n" +
                "(____/(__)(__)(____)(____)  (____)\n");
    }

    @Override
    public void printBall3() {
        System.out.println("\n" +
                " ____    __    __    __      ___ \n" +
                "(  _ \\  /__\\  (  )  (  )    (__ )\n" +
                " ) _ < /(__)\\  )(__  )(__    (_ \\\n" +
                "(____/(__)(__)(____)(____)  (___/\n");
    }

    @Override
    public void printReady() {
        System.out.println("\n" +
                " ____  ____    __    ____  _  _ \n" +
                "(  _ \\( ___)  /__\\  (  _ \\( \\/ )\n" +
                " )   / )__)  /(__)\\  )(_) )\\  / \n" +
                "(_)\\_)(____)(__)(__)(____/ (__) \n");
    }
}
