package fi.matiaspaavilainen.masuitepunish.core;

public enum PunishmentType {
    BAN(1),
    BANIP(1),
    TEMPBAN(1),
    MUTE(2),
    KICK(3),
    WARN(4);

    private final int type;

    PunishmentType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
