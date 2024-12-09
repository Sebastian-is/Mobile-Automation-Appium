package Tests;

import Adapter.Bases.BaseMobileTest;
import Adapter.Screens.*;
import Utils.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MyTest extends BaseMobileTest {

    @Test
    public void testMovieOverview(){
        WelcomeScreen welcomeScreen = new WelcomeScreen(driver);

        welcomeScreen.clickContinue();
        HomeScreen homeScreen = welcomeScreen.clickNotNow();

        String movieTitle = TestDataReader.get("movie.title");

        SearchScreen searchScreen = homeScreen.clickSearchBar();
        searchScreen.inputTttle(movieTitle);
        SelectedMovieScreen selectedMovieScreen = searchScreen.selectFirstMovie();

        selectedMovieScreen.isTitleVisible();

        String expectedOverview = TestDataReader.get("movie.overview");

        String actualOverview = selectedMovieScreen.getOverviewText();
        Assert.assertEquals(actualOverview, expectedOverview, "The movie overview text does not match.");
        
    }

    @Test
    public void WatchList(){
        WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
        welcomeScreen.clickContinue();
        imdbAccountScreen imdbAccountScreen = welcomeScreen.clickIMDB();

        String email = TestDataReader.get("imdb.email");
        String pass = TestDataReader.get("imdb.pass");

        imdbAccountScreen.setSignInEmail(email);
        imdbAccountScreen.setPassword(pass);
        SearchScreen searchScreen = imdbAccountScreen.clickSignIn();

        searchScreen.navigateToSearch();

        String movieTitle = TestDataReader.get("movie.title");

        searchScreen.inputTttle(movieTitle);

        SelectedMovieScreen selectedMovieScreen = searchScreen.anyMovie();

        selectedMovieScreen.isTitleVisible();
        String titleBefore = selectedMovieScreen.getTitle();
        selectedMovieScreen.clickAddToWatchList();
        selectedMovieScreen.clickNotAgain();

        ProfileScreen profileScreen = selectedMovieScreen.goToProfile();

        WatchListScreen watchListScreen = profileScreen.clickWatchList();

        selectedMovieScreen = watchListScreen.clickMovieInWatchList();

        String titleAfter = selectedMovieScreen.getTitle();

        Assert.assertEquals(titleBefore,titleAfter,"La película añadida a la watchlist no es la misma");

        watchListScreen = selectedMovieScreen.goBackToWatchList();

        watchListScreen.clickMovieMenu();
        watchListScreen.removeMovie();
        watchListScreen.yesRemove();
    }

    @Test
    public void userReviews(){
        WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
        welcomeScreen.clickContinue();
        imdbAccountScreen imdbAccountScreen = welcomeScreen.clickIMDB();

        String email = TestDataReader.get("imdb.email");
        String pass = TestDataReader.get("imdb.pass");

        imdbAccountScreen.setSignInEmail(email);
        imdbAccountScreen.setPassword(pass);
        SearchScreen searchScreen = imdbAccountScreen.clickSignIn();

        searchScreen.navigateToSearch();

        String movieTitle = TestDataReader.get("movie.title");

        searchScreen.inputTttle(movieTitle);

        SelectedMovieScreen selectedMovieScreen = searchScreen.selectFirstMovie();

        selectedMovieScreen.getTitle();

        selectedMovieScreen.clickRateButton();

        selectedMovieScreen.selectRandomStar();
        selectedMovieScreen.clickRatingButton();
        selectedMovieScreen.isRatingSavedDisplayed();

    }
}


