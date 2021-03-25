package com.drukhary.laba_2.AreaChecking;

public enum Status {
        WRONG_DATA("Неверные данные"),
        WRONG_FORMAT("Данные имеют неверный формат из допустимой области"),
        OUT_OF_RANGE("Данные выходят из допустимой области"),
        FALSE("Точка не попадает в область"),
        TRUE("Точка попадает в область");
        private final String message;

        Status(String url) {
                this.message = url;
        }

        public String getMessage() {
                return message;
        }
}
