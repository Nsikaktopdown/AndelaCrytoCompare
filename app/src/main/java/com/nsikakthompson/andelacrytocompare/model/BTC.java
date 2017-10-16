package com.nsikakthompson.andelacrytocompare.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nsikak on 10/16/17.
 */

public class BTC {
    @SerializedName("USD")
    double USD;
    @SerializedName("EUR")
    double EUR;
    @SerializedName("GBP")
    double GBP;
    @SerializedName("NGN")
    double NGN;
    @SerializedName("CAD")
    double CAD;
    @SerializedName("SGD")
    double SGD;
    @SerializedName("CHF")
    double CHF;
    @SerializedName("MYR")
    double MYR;
    @SerializedName("JPY")
    double JPY;
    @SerializedName("CNY")
    double CNY;
    @SerializedName("BRL")
    double BRL;
    @SerializedName("EGP")
    double EGP;
    @SerializedName("GHS")
    double GHS;
    @SerializedName("KRW")
    double KRW;
    @SerializedName("MXN")
    double MXN;
    @SerializedName("QAR")
    double QAR;
    @SerializedName("RUB")
    double RUB;
    @SerializedName("SAR")
    double SAR;
    @SerializedName("ZAR")
    double ZAR;

    @Override
    public String toString() {
        return "BTC{" +
                "USD=" + USD +
                ", EUR=" + EUR +
                ", GBP=" + GBP +
                ", NGN=" + NGN +
                ", CAD=" + CAD +
                ", SGD=" + SGD +
                ", CHF=" + CHF +
                ", MYR=" + MYR +
                ", JPY=" + JPY +
                ", CNY=" + CNY +
                ", BRL=" + BRL +
                ", EGP=" + EGP +
                ", GHS=" + GHS +
                ", KRW=" + KRW +
                ", MXN=" + MXN +
                ", QAR=" + QAR +
                ", RUB=" + RUB +
                ", SAR=" + SAR +
                ", ZAR=" + ZAR +
                '}';
    }

    public double getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = USD;
    }

    public double getEUR() {
        return EUR;
    }

    public void setEUR(double EUR) {
        this.EUR = EUR;
    }

    public double getGBP() {
        return GBP;
    }

    public void setGBP(double GBP) {
        this.GBP = GBP;
    }

    public double getNGN() {
        return NGN;
    }

    public void setNGN(double NGN) {
        this.NGN = NGN;
    }

    public double getCAD() {
        return CAD;
    }

    public void setCAD(double CAD) {
        this.CAD = CAD;
    }

    public double getSGD() {
        return SGD;
    }

    public void setSGD(double SGD) {
        this.SGD = SGD;
    }

    public double getCHF() {
        return CHF;
    }

    public void setCHF(double CHF) {
        this.CHF = CHF;
    }

    public double getMYR() {
        return MYR;
    }

    public void setMYR(double MYR) {
        this.MYR = MYR;
    }

    public double getJPY() {
        return JPY;
    }

    public void setJPY(double JPY) {
        this.JPY = JPY;
    }

    public double getCNY() {
        return CNY;
    }

    public void setCNY(double CNY) {
        this.CNY = CNY;
    }

    public double getBRL() {
        return BRL;
    }

    public void setBRL(double BRL) {
        this.BRL = BRL;
    }

    public double getEGP() {
        return EGP;
    }

    public void setEGP(double EGP) {
        this.EGP = EGP;
    }

    public double getGHS() {
        return GHS;
    }

    public void setGHS(double GHS) {
        this.GHS = GHS;
    }

    public double getKRW() {
        return KRW;
    }

    public void setKRW(double KRW) {
        this.KRW = KRW;
    }

    public double getMXN() {
        return MXN;
    }

    public void setMXN(double MXN) {
        this.MXN = MXN;
    }

    public double getQAR() {
        return QAR;
    }

    public void setQAR(double QAR) {
        this.QAR = QAR;
    }

    public double getRUB() {
        return RUB;
    }

    public void setRUB(double RUB) {
        this.RUB = RUB;
    }

    public double getSAR() {
        return SAR;
    }

    public void setSAR(double SAR) {
        this.SAR = SAR;
    }

    public double getZAR() {
        return ZAR;
    }

    public void setZAR(double ZAR) {
        this.ZAR = ZAR;
    }
}
