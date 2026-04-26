// Package declaration thingy
package HopliteRecipes.hopliteRecipes;

// Necessary imports
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

// Registers program as Java-compatible plugin
public class HopliteRecipes extends JavaPlugin {

    @Override
    public void onEnable() {
        // A. Clears vanilla recipes
        removeVanillaRecipe(Material.ANVIL);
        removeVanillaRecipe(Material.GOLDEN_APPLE);

        // B. Registers new ones
        registerAnvilRecipe();
        registerXPBottleRecipe();
        registerBundledArrowsRecipe();
        registerGoldenAppleRecipe();
        registerObsidianRecipe();
    }

    private void removeVanillaRecipe(Material material) {
        java.util.Iterator<org.bukkit.inventory.Recipe> it = Bukkit.recipeIterator();
        while (it.hasNext()) {
            org.bukkit.inventory.Recipe recipe = it.next();
            if (recipe.getResult().getType() == material) {
                it.remove();
            }
        }
    }

    // 1. ANVIL (3 Ingots top, 1 Block mid, 3 Ingots bottom)
    private void registerAnvilRecipe() {
        NamespacedKey key = new NamespacedKey(this, "custom_anvil");
        ShapedRecipe recipe = new ShapedRecipe(key, new ItemStack(Material.ANVIL));
        recipe.shape("III", " B ", "III");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('B', Material.IRON_BLOCK);
        Bukkit.addRecipe(recipe);
    }

    // 2. XP BOTTLE (Lapis cross, Bottle centre)
    private void registerXPBottleRecipe() {
        NamespacedKey key = new NamespacedKey(this, "xp_bottle");
        ShapedRecipe recipe = new ShapedRecipe(key, new ItemStack(Material.EXPERIENCE_BOTTLE, 8));
        recipe.shape(" L ", "LBL", " L ");
        recipe.setIngredient('L', Material.LAPIS_BLOCK);
        recipe.setIngredient('B', Material.GLASS_BOTTLE);
        Bukkit.addRecipe(recipe);
    }

    // 3. BUNDLED ARROWS (Flint top, Stick mid, Feather bottom)
    private void registerBundledArrowsRecipe() {
        NamespacedKey key = new NamespacedKey(this, "bundled_arrows");
        ShapedRecipe recipe = new ShapedRecipe(key, new ItemStack(Material.ARROW, 20));
        recipe.shape("FFF", "SSS", "PPP");
        recipe.setIngredient('F', Material.FLINT);
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('P', Material.FEATHER);
        Bukkit.addRecipe(recipe);
    }

    // 4. GOLDEN APPLE (Gold Ingot cross, Apple Centre)
    private void registerGoldenAppleRecipe() {
        NamespacedKey key = new NamespacedKey(this, "custom_golden_apple");
        ShapedRecipe recipe = new ShapedRecipe(key, new ItemStack(Material.GOLDEN_APPLE));
        recipe.shape(" G ", "GAG", " G ");
        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('A', Material.APPLE);
        Bukkit.addRecipe(recipe);
    }

    // 5. OBSIDIAN (Water Bucket + Lava Bucket)
    private void registerObsidianRecipe() {
        NamespacedKey key = new NamespacedKey(this, "custom_obsidian");
        ShapedRecipe recipe = new ShapedRecipe(key, new ItemStack(Material.OBSIDIAN));
        recipe.shape("WL ", "   ", "   ");
        recipe.setIngredient('W', Material.WATER_BUCKET);
        recipe.setIngredient('L', Material.LAVA_BUCKET);
        Bukkit.addRecipe(recipe);
    }
}