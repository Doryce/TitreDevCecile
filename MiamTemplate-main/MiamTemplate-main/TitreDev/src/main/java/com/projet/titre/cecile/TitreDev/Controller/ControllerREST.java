package com.projet.titre.cecile.TitreDev.Controller;

import com.projet.titre.cecile.TitreDev.Entities.Recipe;
import com.projet.titre.cecile.TitreDev.Entities.UserMiam;
import com.projet.titre.cecile.TitreDev.Service.RecipeService;
import com.projet.titre.cecile.TitreDev.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerREST {
    @Autowired
    UserService userService;

    @Autowired
    RecipeService recipe;

    @PostMapping("/saveUser")
    public UserMiam saveUser(UserMiam user){
        return userService.saveUser(user);
    }

    @RequestMapping(value= "/UpdatePass", method = RequestMethod.POST)
    public void updateUser(@RequestBody String mdp){
        System.out.println(mdp);
        userService.updateUser(mdp);
    }

    @PostMapping("/saveRecipe")
    public Recipe saveRecipe(Recipe recette){
        return recipe.saveRecipe(recette);
    }

    @RequestMapping(value= "/UpdateRecipe")
    public void  updateRecipe(long idRecipe, Recipe recette){
        recipe.updateRecipe(idRecipe, recette);
    }

    @RequestMapping(value = "/deleteRecipe/{id}")
    public void deleteRecipe(@PathVariable long id){
        recipe.deleteRecipeById(id);
    }
}
