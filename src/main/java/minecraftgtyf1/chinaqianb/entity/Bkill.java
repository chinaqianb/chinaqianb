package minecraftgtyf1.chinaqianb.entity;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import minecraftgtyf1.chinaqianb.Chinaqianb;
import minecraftgtyf1.chinaqianb.sounds.CHA;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class Bkill extends PathAwareEntity {
	private ServerBossBar bar ;
	public Bkill(EntityType<? extends PathAwareEntity> entityType, World world) {
		super(entityType, world);
		this.bar =(ServerBossBar) (new ServerBossBar(Text.translatable("BOSS_Bkill"),
				BossBar.Color.BLUE,BossBar.Style.PROGRESS));
	}
	public static DefaultAttributeContainer.Builder createLivingAttributes(){//实体属性
		return PathAwareEntity.createMobAttributes()
				.add(EntityAttributes.GENERIC_MAX_HEALTH,100)//最大血量
		        .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,1.0f)
				.add(EntityAttributes.GENERIC_ATTACK_SPEED,1.0f)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.4f);
	}
	@Override
	protected void initGoals() {//ai行为逻辑


		/*
		priority:优先级，越低越优先
		 */
		this.goalSelector.add(2,new WanderAroundGoal(this,0.5f));//到处走
		this.goalSelector.add(1,new MeleeAttackGoal(this,1.2D,false));

		//寻找目标
		this.targetSelector.add(1,new ActiveTargetGoal<>(this, ChickenEntity.class,true));
	}

	@Override
	public float getHealth() {
		return super.getHealth();
	}

	@Override
	public void onStartedTrackingBy(ServerPlayerEntity player) {
		super.onStartedTrackingBy(player);
		this.bar.addPlayer(player);
	}

	@Override
	public void onStoppedTrackingBy(ServerPlayerEntity player) {
		super.onStoppedTrackingBy(player);
		this.bar.removePlayer(player);
	}

	@Override
	protected void mobTick() {
		super.mobTick();
		if (this.isAlive()){
			this.bar.setPercent(getHealth()/getMaxHealth());
		}
	}

	@Override
	protected void dropEquipment(DamageSource source, int lootingMultiplier, boolean allowDrops) {
		super.dropEquipment(source, lootingMultiplier, allowDrops);
		this.dropItem(Chinaqianb.jiang);
		this.dropItem(Chinaqianb.eating_b);
		

	}

	@Override
	protected ActionResult interactMob(PlayerEntity player, Hand hand) {//与实体交互
		return super.interactMob(player, hand);
	}
}