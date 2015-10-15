package builder;

// builder pattern
public class NutritionFacts
{

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    private NutritionFacts(Builder builder)
    {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    public static class Builder
    {

        // required parameters
        private final int servingSize;
        private final int servings;

        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings)
        {
            this.servingSize = servingSize;
            this.servings = servings;
            
        }

        public Builder calories(int calories)
        {
            this.calories = calories;
            return this;
        }

        public Builder fat(int fat)
        {
            this.fat = fat;
            return this;
        }

        public Builder sodium(int sodium)
        {
            this.sodium = sodium;
            return this;
        }

        public Builder carbohydrate(int carbohydrate)
        {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFacts build()
        {
            return new NutritionFacts(this);
        }

    }

    public int getServingSize()
    {
        return servingSize;
    }

    public int getServings()
    {
        return servings;
    }

    public int getCalories()
    {
        return calories;
    }

    public int getFat()
    {
        return fat;
    }

    public int getSodium()
    {
        return sodium;
    }

    public int getCarbohydrate()
    {
        return carbohydrate;
    }

    @Override
    public String toString()
    {
        return "NutritionFacts{" + "servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories + ", fat=" + fat + ", sodium=" + sodium + ", carbohydrate=" + carbohydrate + '}';
    }

}
