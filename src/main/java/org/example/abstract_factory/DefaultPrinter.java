package org.example.abstract_factory;

public class DefaultPrinter extends Printer{
    @Override
    public FontStyle createFontStyle() {
        return new FontStyleDefault();
    }
}
