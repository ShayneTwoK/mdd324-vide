package com.ipiecoles.java.mdd324.homepage.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rss {
    Channel channel;

    public Channel getChannel() {
        return channel;
    }

    @XmlElement(name="channel")
    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
