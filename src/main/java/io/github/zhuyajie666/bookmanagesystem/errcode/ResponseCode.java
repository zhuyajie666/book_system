package io.github.zhuyajie666.bookmanagesystem.errcode;

public class ResponseCode<T> {

    private int code;

    private String message;

    private T data;

    public static final ResponseCode SUCCESS = new ResponseCode(200,"success");
    public static final ResponseCode SYSTEM_BUSY = new ResponseCode(500,"success");

    public static final ResponseCode EMAIL_EXIST = new ResponseCode(1000,"Email exist");
    public static final ResponseCode PHONE_EXIST = new ResponseCode(1001,"Phone exist");
    public static final ResponseCode EXIST_BOOK_IN_CATEGORY = new ResponseCode(1002,"current category exist book");
    public static final ResponseCode BOOK_NOT_EXIST = new ResponseCode(1003,"book don't exist");
    public static final ResponseCode BOOK_INVENTORY_NOT_ENOUGH = new ResponseCode(1004,"book inventory not enough");
    public static final ResponseCode BOOK_BORROW_LOG_NOT_EXIST = new ResponseCode(1005,"book borrow log don't exist");
    public static final ResponseCode ACCOUNT_NOT_EXIST = new ResponseCode(1006,"account don't exist");
    public static final ResponseCode PASSWORD_INCORRECT = new ResponseCode(1007,"password is incorrect");
    public static final ResponseCode NOT_YET_LOGIN = new ResponseCode(1008,"not login yet");



    public ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> ResponseCode build(T data) {
        ResponseCode responseCode = new ResponseCode(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMessage());
        responseCode.setData(data);
        return responseCode;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isOk() {
        return code == ResponseCode.SUCCESS.getCode();
    }
}
