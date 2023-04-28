package ray1024.labs.web.lab2.DITA;

import jakarta.servlet.http.HttpServletRequest;
import ray1024.labs.web.lab2.DITA.data.XYR;
import ray1024.labs.web.lab2.DITA.result.DITAResult;
import ray1024.labs.web.lab2.DITA.result.IDITAResult;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class DITARequestApplier {

    static private boolean checkArea(double x, double y, double r) {
        if (x >= -r && x <= 0.0 && y >= 0.0 && y <= r) return true;
        if (x >= -r && x <= 0.0 && y <= 0.0 && (y >= -r / 2.0) && (y >= (-x / 2.0 - r / 2.0))) return true;
        return ((x >= 0.0) && (x <= r / 2.0) && (y <= 0.0) && (y >= -r / 2.0) && (x * x + y * y <= (r * r / 4.0)));
    }

    public static boolean applyRequest(HttpServletRequest request) {
        double x, y, r;
        long startTime = System.nanoTime(), endTime;
        try {
            x = Double.parseDouble(request.getParameter("x").trim().replace(',', '.'));
            //if (Double.compare(x, -2.0) < 0 || Double.compare(x, 2.0) > 0) return false;
            y = Double.parseDouble(request.getParameter("y").trim().replace(',', '.'));
            //if (Double.compare(y, -3.0) <= 0 || Double.compare(y, 5.0) >= 0) return false;
            r = Double.parseDouble(request.getParameter("r").trim().replace(',', '.'));
            if (r <= 2.0 || r >= 5.0) return false;
        } catch (RuntimeException ex) {
            return false;
        }
        try {
            IDITAResult result = new DITAResult().setXyr(new XYR().setX(x).setY(y).setR(r)).setDateTime(LocalDateTime.now()).setResult(checkArea(x, y, r));
            if (request.getSession().getAttribute("collection") == null)
                request.getSession().setAttribute("collection", new LinkedList<IDITAResult>());
            LinkedList<IDITAResult> collection = (LinkedList<IDITAResult>) request.getSession().getAttribute("collection");
            while (collection.size() > 9) collection.removeFirst();
            endTime = System.nanoTime();
            collection.add(result.setExecutionTime(endTime - startTime));
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
