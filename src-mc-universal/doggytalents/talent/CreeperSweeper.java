package doggytalents.talent;

import java.util.List;

import doggytalents.api.inferface.ITalent;
import doggytalents.entity.EntityDog;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

/**
 * @author ProPercivalalb
 */
public class CreeperSweeper extends ITalent {

	@Override
	public void onClassCreation(EntityDog dog) {
		dog.objects.put("canseecreeper", false);
	}

	@Override
	public void onLivingUpdate(EntityDog dog) {
		dog.objects.put("canseecreeper", false);
		int level = dog.talents.getLevel(this);
		
		if(dog.getAttackTarget() == null && dog.isTamed() && level > 0) {
            List list = dog.world.getEntitiesWithinAABB(EntityCreeper.class, dog.getEntityBoundingBox().grow(level * 6));

            if (!list.isEmpty() && !dog.isSitting() && dog.getHealth() > 1)
            	dog.objects.put("canseecreeper", true);
        }
		
		if(dog.getAttackTarget() instanceof EntityCreeper) {
        	EntityCreeper creeper = (EntityCreeper)dog.getAttackTarget();
        	creeper.setCreeperState(-1);
        }
	}
	
	@Override
	public SoundEvent getLivingSound(EntityDog dog) { 
		if((Boolean)dog.objects.get("canseecreeper"))
			return SoundEvents.ENTITY_WOLF_GROWL;
		return null;
	}
	
	@Override
	public boolean canAttackClass(EntityDog dog, Class entityClass) {
		return EntityCreeper.class == entityClass && dog.talents.getLevel(this) == 5; 
	}
	
	@Override
	public boolean canAttackEntity(EntityDog dog, Entity entity) {
		return entity instanceof EntityCreeper && dog.talents.getLevel(this) == 5;
	}
	
	@Override
	public String getKey() {
		return "creepersweeper";
	}

}
