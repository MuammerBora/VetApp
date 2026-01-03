package alert;

// ENUM: Sabit durumları tutar. (Aktif, Bulundu, İptal)
public enum AlertStatus {
    ACTIVE,     // Hâlâ kayıp
    FOUND,      // Bulundu
    CANCELED    // İhbar iptal edildi
}