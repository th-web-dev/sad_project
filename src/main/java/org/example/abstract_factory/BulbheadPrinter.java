package org.example.abstract_factory;

public class BulbheadPrinter extends Printer{
    @Override
    public FontStyle createFontStyle() {
        return new FontStyleBulbhead();
    }
}
