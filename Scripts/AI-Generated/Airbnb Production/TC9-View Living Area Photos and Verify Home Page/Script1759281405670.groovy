import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import truetest.Airbnb_Production.custom.TrueTestScripts

def reportLocation = RunConfiguration.getReportFolder()

'Initialize test session: Open browser and set view port'

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser('')
	WebUI.setViewPortSize(1920, 1080)	
}

"Step 1: Navigate to /rooms/* with params (check in, check out, photo id, previous page section name, source impression id)"

TrueTestScripts.navigate("/rooms/${rooms_id}", ["check_in": rooms_check_in, "check_out": rooms_check_out, "photo_id": rooms_photo_id, "previous_page_section_name": rooms_previous_page_section_name, "source_impression_id": rooms_source_impression_id])

"Step 2: Click on button showAllPhotos"

WebUI.enhancedClick(findTestObject('AI-Generated/Airbnb Production/Page_rooms/button_showAllPhotos'))

// WebUI.takeScreenshot(reportLocation + '/TC9/Step 2-Click on button showAllPhotos.png')

"Step 3: Click on button scrollToLivingArea -> Navigate to page ''"

WebUI.enhancedClick(findTestObject('AI-Generated/Airbnb Production/Page_rooms/button_scrollToLivingArea'))

// WebUI.takeScreenshot(reportLocation + '/TC9/Step 3-Click on button scrollToLivingArea - Navigate to page .png')

"Step 4: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC9-View Living Area Photos and Verify Home Page_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}