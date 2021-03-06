package com.github.prontera.domain.type;

/**
 * @author Wujun
 */
public enum TccStatus {
    TRY(0), CONFIRM(1);

    private final int status;

    TccStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
