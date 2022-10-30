package org.example.abstract_factory;

public class GrafitiPrinter extends Printer{

    @Override
    public FontStyle createFontStyle() {
        return new FontStyleGrafiti();
    }
}
