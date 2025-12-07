Java Class for adding daily bonus rewards for your game

Usage:
```java
bonusSystem = new DailyBonusSystem();
boolean claimedToday = bonusSystem.hasClaimedToday(player.lastClaimTs, player.getTime());
boolean claimedYesterday = bonusSystem.hasClaimedYesterday(player.lastClaimTs, player.getTime());
//int dayClaimed = player.getClaimDay();

if (!claimedToday) {
  //... give bonus or show claim button
  player.updateClaimTs();
  player.addDay();
}
```
