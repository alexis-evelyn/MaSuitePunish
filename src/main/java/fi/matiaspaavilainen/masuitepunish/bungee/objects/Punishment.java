package fi.matiaspaavilainen.masuitepunish.bungee.objects;

import com.google.gson.Gson;
import fi.matiaspaavilainen.masuitepunish.bungee.events.PunishmentEvent;
import fi.matiaspaavilainen.masuitepunish.core.PunishmentType;
import net.md_5.bungee.api.ProxyServer;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

public class Punishment {

    private UUID player;
    private UUID punisher;
    private int reason;
    private String description;

    private PunishmentType punishmentType;

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
    public Punishment(UUID player, UUID punisher, int reason, String description, PunishmentType punishmentType) {
        this.player = player;
        this.punisher = punisher;
        this.reason = reason;
        this.description = description;
        this.punishmentType = punishmentType;
    }

    public Punishment create() {
        ProxyServer.getInstance().getPluginManager().callEvent(new PunishmentEvent(this));
        return this;
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

    public UUID getPlayer() {
        return player;
    }

    public void setPlayer(UUID player) {
        this.player = player;
    }

    public UUID getPunisher() {
        return punisher;
    }

    public void setPunisher(UUID punisher) {
        this.punisher = punisher;
    }

    public int getReason() {
        return reason;
    }

    public void setReason(int reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PunishmentType getPunishmentType() {
        return punishmentType;
    }

    public void setPunishmentType(PunishmentType punishmentType) {
        this.punishmentType = punishmentType;
    }
}
