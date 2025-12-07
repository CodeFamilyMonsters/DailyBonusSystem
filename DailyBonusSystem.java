package ru.miraonline.lines2castle.utility;

public class DailyBonusSystem {

    // Проверяем, брал ли игрок бонус СЕГОДНЯ (после 00:00)
    public boolean hasClaimedToday(double lastClaimTs, double serverTime) {
        return getDayNumber(lastClaimTs) == getDayNumber(serverTime);
    }

    // Проверяем, брал ли игрок бонус ВЧЕРА (в течение вчерашних суток)
    public boolean hasClaimedYesterday(double lastClaimTs, double serverTime) {
        if (lastClaimTs <= 0) return false;
        long lastClaimDay = getDayNumber(lastClaimTs);
        long yesterdayDay = getDayNumber(serverTime) - 1;

        return lastClaimDay == yesterdayDay;
    }

    // Можно ли взять бонус сейчас?
    public boolean canClaimBonus(double lastClaimTs, double serverTime) {
        if (lastClaimTs <= 0) return true; // никогда не брал

        long lastClaimDay = getDayNumber(lastClaimTs);
        long currentDay = getDayNumber(serverTime);

        return lastClaimDay < currentDay; // брал не сегодня
    }

    // Номер дня с эпохи Unix (прошедших дней с 1 января 1970)
    public long getDayNumber(double timestamp) {
        return (long) timestamp / (24 * 60 * 60 * 1000L);
    }

    public int getDayNumberWeekly(double timestamp) {
        return (int) (getDayNumber(timestamp)%7);
    }

}
