package lotto.view;

public enum Views {

    REQUEST_MONEY("구입금액을 입력해 주세요."),
    LOTTOS_COUNT("%s개를 구매했습니다."),
    ;

    private final String format;

    Views(String format) {
        this.format = format;
    }

    public String render() {
        return format;
    }

    public String render(String... data) {
        return String.format(format, data);
    }
}
