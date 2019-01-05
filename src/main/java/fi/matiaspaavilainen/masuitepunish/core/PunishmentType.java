package fi.matiaspaavilainen.masuitepunish.core;

public enum PunishmentType {
    BAN(1),
    BAN_IP(1),
    TEMP_BAN(1),
    MUTE(2),
    TEMP_MUTE(2),
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
