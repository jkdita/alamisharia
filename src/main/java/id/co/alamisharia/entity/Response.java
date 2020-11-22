package id.co.alamisharia.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    private int code;
    private String status;
    private String message;
    private Object data;

    public Response() {
    }

    public Response(int code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public Response(int code, String status, String message, Object data) {
        this(code, status, message);
        this.data = data;
    }

    public Response(String message) {
        this.code = HttpStatus.BAD_REQUEST.value();;
        this.status = "Error";
        this.message = message;
    }

    public Response(int code, String message) {
        this.code = code;
        this.status = "Error";
        this.message = message;
    }

    public Response(Object data) {
        this.code = HttpStatus.OK.value();
        this.status = "Success";
        this.message = "";
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}