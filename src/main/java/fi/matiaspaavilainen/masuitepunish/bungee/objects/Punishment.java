package fi.matiaspaavilainen.masuitepunish.bungee.objects;

import fi.matiaspaavilainen.masuitepunish.core.PunishmentType;

import java.util.UUID;

public class Punishment {

    private UUID player;
    private UUID punisher;
    private int reason;
    private String description;
    private PunishmentType punishmentType;

    private long created;
    private long ends;

    /**
     * An empty constructor for Punishment
     */
    public Punishment() {
    }

    /**
     * A constructor for Punisment
     *
     * @param player         the bad guy
     * @param punisher       the punisher
     * @param reason         reason of the punishment
     * @param description    a better description of punishment
     * @param punishmentType {@link PunishmentType} is the punishment ban, mute, kick etc.
     */
    public Punishment(UUID player, UUID punisher, int reason, String description, PunishmentType punishmentType, long created, long ends) {
        this.player = player;
        this.punisher = punisher;
        this.reason = reason;
        this.description = description;
        this.punishmentType = punishmentType;
        this.created = created;
        this.ends = ends;
    }

    public boolean create() {

        // TODO: Add saving

        return true;
    }

    /*public void discord() {
        try {
            HashMap<String, Object> data = new LinkedHashMap<>();

            List<Object> embeds = new ArrayList<>();

            HashMap<String, Object> info = new LinkedHashMap<>();
            data.put("username", "MaSuite");
            data.put("avatar_url", "http://matiaspaavilainen.fi/masuite/Core-MaSuite-DC.png");
            data.put("content", "This is a test request");

            HashMap<String, Object> author = new HashMap<>();
            author.put("name", "Masapelipelaa has been banned");
            author.put("icon_url", "https://crafatar.com/avatars/dd359b91-f211-4f74-b67c-cdc8916e3972?size=512");
            info.put("color", 3447003);
            info.put("author", author);

            List<Object> fields = new ArrayList<>();

            HashMap<String, Object> punisher = new HashMap<>();
            punisher.put("name", "Punisher");
            punisher.put("value", "Masagameplay");
            punisher.put("inline", true);

            HashMap<String, Object> length = new HashMap<>();
            length.put("name", "Length");
            length.put("value", "1 day");
            length.put("inline", true);

            HashMap<String, Object> reason = new HashMap<>();
            reason.put("name", "Reason");
            reason.put("value", "Being noob");
            reason.put("inline", true);

            HashMap<String, Object> description = new HashMap<>();
            description.put("name", "Description");
            description.put("value", "Cannot play Minecraft");
            description.put("inline", true);

            fields.add(punisher);
            fields.add(length);
            fields.add(reason);
            fields.add(description);
            info.put("fields", fields);
            embeds.add(info);
            data.put("embeds", embeds);


            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost postRequest = new HttpPost("");
            Gson gson = new Gson();
            System.out.println(gson.toJson(data));
            String json = gson.toJson(gson.toJson(data));
            postRequest.setEntity(new StringEntity(json));
            postRequest.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            postRequest.setHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Android 4.4; Mobile; rv:41.0) Gecko/41.0 Firefox/41.0");
            try (CloseableHttpResponse httpResponse = httpClient.execute(postRequest)) {
                String content = EntityUtils.toString(httpResponse.getEntity());

                int statusCode = httpResponse.getStatusLine().getStatusCode();
                System.out.println("statusCode = " + statusCode);
                System.out.println("content = " + content);
            } catch (IOException e) {
                //handle exception
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

    /**
     * @return the punished player
     */
    public UUID getPlayer() {
        return player;
    }
    /**
     * @param player uuid of the punished player
     */
    public void setPlayer(UUID player) {
        this.player = player;
    }

    /**
     * @return the punisher
     */
    public UUID getPunisher() {
        return punisher;
    }

    /**
     * @param punisher the punisher
     */
    public void setPunisher(UUID punisher) {
        this.punisher = punisher;
    }

    /**
     * @return Reason code specified in config
     */
    public int getReason() {
        return reason;
    }

    /**
     * @param reason Reason code specified in config
     */
    public void setReason(int reason) {
        this.reason = reason;
    }

    /**
     * @return Longer description of the punishment
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description Longer description of the punishment
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return {@link PunishmentType}
     */
    public PunishmentType getPunishmentType() {
        return punishmentType;
    }

    /**
     * @param punishmentType {@link PunishmentType}
     */
    public void setPunishmentType(PunishmentType punishmentType) {
        this.punishmentType = punishmentType;
    }

    /**
     * @return How long does the punishment take
     */
    public long getLength() {
        return this.ends - this.created;
    }

    /**
     * @return when the punishment was created
     */
    public long getCreated() {
        return created;
    }

    /**
     * @param created when the punishment is created
     */
    public void setCreated(long created) {
        this.created = created;
    }

    /**
     * @return when the punishment ends
     */
    public long getEnds() {
        return ends;
    }

    /**
     * @param ends when the punishment ends
     */
    public void setEnds(long ends) {
        this.ends = ends;
    }
}
