package mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;


/**
 * Created by wahrons on 24/03/17.
 */
public class MQTTPublisher implements MqttCallback {
    public void publishMessage(MqttClient mqttClient, String topicDescription, String message)
            throws MqttException {

        System.out.println(topicDescription);
        MqttTopic topic = mqttClient.getTopic(topicDescription);

        int pubQoS = 0;
        MqttMessage mqttMessage = new MqttMessage(message.getBytes());
        mqttMessage.setQos(pubQoS);
        mqttMessage.setRetained(false);

        MqttDeliveryToken token = topic.publish(mqttMessage);
        token.waitForCompletion();

    }

    public void connectionLost(Throwable throwable) {
        throw new RuntimeException("Connection Lost.", throwable);
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        throw new RuntimeException("Should not receive any message");
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        System.out.println("Delivery Complete.");
    }
}
