package alert;

import animal.Animal;
import people.PetOwner;
import java.util.Date;

///kayıp durumu vesaire
public class MissingAlert {
    private Animal animal;
    private PetOwner owner;
    private Date dateLost;
    private String lastSeenLocation; // Son görüldüğü yer
    private double reward; // Para ödülü
    private AlertStatus status;

    public MissingAlert(Animal animal, PetOwner owner, String lastSeenLocation, double reward) {
        this.animal = animal;
        this.owner = owner;
        this.lastSeenLocation = lastSeenLocation;
        this.reward = reward;
        this.dateLost = new Date(); // Şu anki tarihi atar
        this.status = AlertStatus.ACTIVE; // İlk oluştuğunda durumu AKTİF olur
    }

    public void resolveAlert() {
        this.status = AlertStatus.FOUND;
    }

    @Override
    public String toString() {
        return "⚠️ MISSING: " + animal.getName() + " (" + animal.getClass().getSimpleName() + ")\n" +
                "📍 Last Seen: " + lastSeenLocation + "\n" +
                "💰 Reward: $" + reward + "\n" +
                "📞 Contact: " + owner.getName() + "\n" +
                "Status: " + status;
    }
}