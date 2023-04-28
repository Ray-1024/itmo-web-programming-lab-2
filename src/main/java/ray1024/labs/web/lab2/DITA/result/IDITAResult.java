package ray1024.labs.web.lab2.DITA.result;

import ray1024.labs.web.lab2.DITA.data.IXYR;

import java.time.LocalDateTime;

public interface IDITAResult {
    long getExecutionTime();

    IDITAResult setExecutionTime(long executionTime);

    IDITAResult setDateTime(LocalDateTime dateTime);

    LocalDateTime getDateTime();

    IDITAResult setXyr(IXYR xyr);

    IXYR getXyr();

    boolean getResult();

    IDITAResult setResult(boolean result);
}
