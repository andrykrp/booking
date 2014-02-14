package org.octocode.booking.model;

public class JsonResponse {
    private String status = null;
    private Object result = null;

    public JsonResponse(String st, Object res)
    {
        status = st;
        result = res;
    }

    public String getStatus() {
            return status;
    }

    public void setStatus(String status) {
            this.status = status;
    }

    public Object getResult() {
            return result;
    }

    public void setResult(Object result) {
            this.result = result;
    }
}

