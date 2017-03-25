import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import mqtt.MQTTConnect;
import mqtt.MQTTSubscriber;

/**
 * Created by wahrons on 24/03/17.
 */
public class SubscriberRunner {

    public static void main(String[] args) throws InterruptedException, MqttException {
        MQTTConnect mqttConnect = new MQTTConnect();
        MQTTSubscriber mqttSubscriber = new MQTTSubscriber();

        MqttClient connect = mqttConnect.connect(mqttSubscriber);
        String topic = mqttConnect.getTopic();
        mqttSubscriber.subscribe(connect, topic);
        Thread.sleep(5000);
    }
}
