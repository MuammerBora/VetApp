package repository;

import alert.MissingAlert;
import java.util.ArrayList;

public class AlertRepository {
    private static ArrayList<MissingAlert> allAlerts = new ArrayList<>();

    public static void addAlert(MissingAlert alert) {
        allAlerts.add(alert);
    }

    public static ArrayList<MissingAlert> getAllAlerts() {
        return allAlerts;
    }
}