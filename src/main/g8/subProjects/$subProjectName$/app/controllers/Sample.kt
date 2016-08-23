package controllers

import play.mvc.Controller
import play.mvc.Result

/**
 * Created by kk on 16/8/23.
 */

class Sample : Controller() {


    fun kktest() : Result {
        return ok("Sub project controller class. sub project name is: $subProjectName$")
    }

}