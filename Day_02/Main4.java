import java.util.*;

// MealPlan interface
interface MealPlan {
    String getMealDetails();
}

// Subtypes of MealPlan
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Vegetarian meal: Lentils, Rice, Vegetables";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Vegan meal: Tofu, Quinoa, Broccoli";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Keto meal: Eggs, Avocado, Grilled Chicken";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "High-Protein meal: Salmon, Beans, Eggs";
    }
}

// Generic Meal class
class Meal<T extends MealPlan> {
    private T mealType;

    public Meal(T mealType) {
        this.mealType = mealType;
    }

    public void showMeal() {
        System.out.println(mealType.getMealDetails());
    }

    public T getMealType() {
        return mealType;
    }
}

// Generator class
class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T meal) {
        // Simple validation logic (example: reject null meals)
        if (meal == null) {
            throw new IllegalArgumentException("Invalid meal plan!");
        }
        System.out.println("Meal plan generated successfully.");
        return new Meal<>(meal);
    }
}

public class Main4 {
    public static void main(String[] args) {
        VegetarianMeal veg = new VegetarianMeal();
        VeganMeal vegan = new VeganMeal();
        KetoMeal keto = new KetoMeal();
        HighProteinMeal highProtein = new HighProteinMeal();

        
        Meal<VegetarianMeal> vegMeal = MealPlanGenerator.generateMealPlan(veg);
        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(vegan);
        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(keto);
        Meal<HighProteinMeal> highProteinMeal = MealPlanGenerator.generateMealPlan(highProtein);

        
        vegMeal.showMeal();
        veganMeal.showMeal();
        ketoMeal.showMeal();
        highProteinMeal.showMeal();
    }
}

