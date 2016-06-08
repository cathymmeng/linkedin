package helper

import geb.Browser

class AnimationHelper {
    def static waitForAnimationsToComplete() {
        Browser.drive {
            waitFor {
                js.exec("return jQuery(':animated').length") == 0
            }
        }
    }

    static void waitForAjaxToComplete(int time = 6) {
        Browser.drive {
            waitFor(time, 1) {
                !js.exec('return $.active > 0;')
            }
        }
    }

}
