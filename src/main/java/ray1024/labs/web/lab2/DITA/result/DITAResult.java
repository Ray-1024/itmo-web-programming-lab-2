package ray1024.labs.web.lab2.DITA.result;

import ray1024.labs.web.lab2.DITA.data.IXYR;

import java.time.LocalDateTime;

public class DITAResult implements IDITAResult {
    private long executionTime;
    private LocalDateTime dateTime;
    private IXYR xyr;
    private boolean result;

    @Override
    public long getExecutionTime() {
        return executionTime;
    }

    @Override
    public IDITAResult setDateTime(LocalDateTime newDateTime) {
        dateTime = newDateTime;
        return this;
    }

    @Override
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public IDITAResult setXyr(IXYR ixyr) {
        xyr = ixyr;
        return this;
    }

    @Override
    public IXYR getXyr() {
        return xyr;
    }

    @Override
    public boolean getResult() {
        return result;
    }

    @Override
    public IDITAResult setExecutionTime(long execTime) {
        executionTime = execTime;
        return this;
    }

    @Override
    public IDITAResult setResult(boolean res) {
        result = res;
        return this;
    }
}
