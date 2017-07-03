package com.bupt.dto;

/**
 * Created by 韩宪斌 on 2017/7/3.
 */
public class TopologyLinkDTO {
    private String linkId;
    private String linkName;
    private String linkNameFull;
    private String linkRate;
    private Long linkLength;
    private String linkSyncStatus;
    private String endAPortId;
    private String endZPortId;
    private String endAStationId;
    private String endZStationId;
    private String endAEquipId;
    private String endZEquipId;
    private String endAEquipSystemName;
    private String endZEquipSystemName;

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkNameFull() {
        return linkNameFull;
    }

    public void setLinkNameFull(String linkNameFull) {
        this.linkNameFull = linkNameFull;
    }

    public String getLinkRate() {
        return linkRate;
    }

    public void setLinkRate(String linkRate) {
        this.linkRate = linkRate;
    }

    public Long getLinkLength() {
        return linkLength;
    }

    public void setLinkLength(Long linkLength) {
        this.linkLength = linkLength;
    }

    public String getLinkSyncStatus() {
        return linkSyncStatus;
    }

    public void setLinkSyncStatus(String linkSyncStatus) {
        this.linkSyncStatus = linkSyncStatus;
    }

    public String getEndAPortId() {
        return endAPortId;
    }

    public void setEndAPortId(String endAPortId) {
        this.endAPortId = endAPortId;
    }

    public String getEndZPortId() {
        return endZPortId;
    }

    public void setEndZPortId(String endZPortId) {
        this.endZPortId = endZPortId;
    }

    public String getEndAStationId() {
        return endAStationId;
    }

    public void setEndAStationId(String endAStationId) {
        this.endAStationId = endAStationId;
    }

    public String getEndZStationId() {
        return endZStationId;
    }

    public void setEndZStationId(String endZStationId) {
        this.endZStationId = endZStationId;
    }

    public String getEndAEquipId() {
        return endAEquipId;
    }

    public void setEndAEquipId(String endAEquipId) {
        this.endAEquipId = endAEquipId;
    }

    public String getEndZEquipId() {
        return endZEquipId;
    }

    public void setEndZEquipId(String endZEquipId) {
        this.endZEquipId = endZEquipId;
    }

    public String getEndAEquipSystemName() {
        return endAEquipSystemName;
    }

    public void setEndAEquipSystemName(String endAEquipSystemName) {
        this.endAEquipSystemName = endAEquipSystemName;
    }

    public String getEndZEquipSystemName() {
        return endZEquipSystemName;
    }

    public void setEndZEquipSystemName(String endZEquipSystemName) {
        this.endZEquipSystemName = endZEquipSystemName;
    }
}
