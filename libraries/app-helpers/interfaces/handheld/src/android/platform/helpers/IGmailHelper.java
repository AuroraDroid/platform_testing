/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.platform.helpers;

import androidx.test.uiautomator.Direction;
import androidx.test.uiautomator.UiObject2;

import java.util.List;

public interface IGmailHelper extends IAppHelper {

    /**
     * Setup expectations: Gmail is open and the navigation bar is visible.
     *
     * <p>This method will navigate to the Inbox or Primary, depending on the name.
     */
    public void goToInbox();

    /** Alias method for AbstractGmailHelper#goToInbox */
    public void goToPrimary();

    /**
     * Setup expectations: Gmail is open on the Inbox or Primary page.
     *
     * <p>This method will open a new e-mail to compose and block until complete.
     */
    public void goToComposeEmail();

    /**
     * Checks if the current view is the compose email view.
     *
     * @return true if the current view is the compose email view, false otherwise.
     */
    public boolean isInComposeEmail();

    /**
     * Checks if the app is open on the Inbox or Primary page.
     *
     * @return true if the current view is the Inbox or Primary page, false otherwise.
     */
    public boolean isInPrimaryOrInbox();

    /**
     * Setup expectations: Gmail is open and on the Inbox or Primary page.
     *
     * <p>This method will open the (index)'th visible e-mail in the list and block until the e-mail
     * is visible in the foreground. The top-most visible e-mail will always be labeled 0. To get
     * the number of visible e-mails, consult the getVisibleEmailCount() function.
     */
    public void openEmailByIndex(int index);

    /**
     * Setup expectations: Gmail is open and on the Inbox or Primary page.
     *
     * <p>This method will return the number of visible e-mails for use with the #openEmailByIndex
     * method.
     */
    public int getVisibleEmailCount();

    /**
     * Setup expectations: Gmail is open and an e-mail is open in the foreground.
     *
     * <p>This method will press reply, send a reply e-mail with the given parameters, and block
     * until the original message is in the foreground again.
     */
    public void sendReplyEmail(String address, String body);

    /**
     * Setup expectations: Gmail is open and composing an e-mail.
     *
     * <p>This method will set the e-mail's To address and block until complete.
     */
    public void setEmailToAddress(String address);

    /**
     * Setup expectations: Gmail is open and composing an e-mail.
     *
     * <p>This method will set the e-mail's subject and block until complete.
     */
    public void setEmailSubject(String subject);

    /**
     * Setup expectations: Gmail is open and composing an e-mail.
     *
     * <p>This method will set the e-mail's Body (doesn't use keyboard) and block until complete.
     * Focus will remain on the e-mail body after completion.
     *
     * <p>* @param body The messages to input in the e-mail body.
     */
    public void setEmailBody(String body);

    /**
     * Setup expectations: Gmail is open and composing an e-mail.
     *
     * <p>This method inputs the e-mail body.
     *
     * @param body The messages to input in the e-mail body.
     * @param useKeyboard Types out the e-mail body by keyboard or not.
     */
    public default void setEmailBody(String body, boolean useKeyboard) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    /**
     * Setup expectations: Gmail is open and composing an e-mail.
     *
     * <p>This method will press send and block until the device is idle on the original e-mail.
     */
    public void clickSendButton();

    /**
     * Setup expectations: Gmail is open and composing an e-mail.
     *
     * <p>This method will get the e-mail's composition's body and block until complete.
     *
     * @return {String} the text contained in the email composition's body.
     */
    public String getComposeEmailBody();

    /**
     * Setup expectations: Gmail is open and the navigation drawer is visible.
     *
     * <p>This method will open the navigation drawer and block until complete.
     */
    public void openNavigationDrawer();

    /**
     * Setup expectations: Gmail is open and the navigation drawer is open.
     *
     * <p>This method will close the navigation drawer and returns true otherwise false
     */
    public boolean closeNavigationDrawer();

    /**
     * Setup expectations: Gmail is open and the navigation drawer is open.
     *
     * <p>This method will scroll the navigation drawer and block until idle. Only accepts UP and
     * DOWN.
     */
    public void scrollNavigationDrawer(Direction dir);

    /**
     * Setup expectations: Gmail is open and the navigation drawer is open.
     *
     * <p>This method will fling the navigation drawer and block until idle. Only accepts UP and
     * DOWN.
     */
    public void flingNavigationDrawer(Direction dir);

    /**
     * Setup expectations: Gmail is open and a mailbox is open.
     *
     * <p>This method will scroll the mailbox view.
     *
     * @param direction The direction to scroll, only accepts UP and DOWN.
     * @param amount The amount to scroll
     * @param scrollToEnd Whether or not to scroll to the end
     */
    public void scrollMailbox(Direction direction, float amount, boolean scrollToEnd);

    /**
     * Setup expectations: Gmail is open and an email is open.
     *
     * <p>This method will scroll the current email.
     *
     * @param direction The direction to scroll, only accepts UP and DOWN.
     * @param amount The amount to scroll
     * @param scrollToEnd Whether or not to scroll to the end
     */
    public void scrollEmail(Direction direction, float amount, boolean scrollToEnd);

    /**
     * Setup expectations: Gmail is open and the navigation drawer is open.
     *
     * <p>This method will open the mailbox with the given name and block until emails in that
     * mailbox have loaded.
     *
     * @param mailboxName The case insensitive name of the mailbox to open
     */
    public void openMailbox(String mailboxName);

    /**
     * Setup expectations: Gmail is open and an email is open.
     *
     * <p>This method will return to the mailbox the current email was opened from.
     */
    public void returnToMailbox();

    /**
     * Setup expectations: Gmail is open and an email is open.
     *
     * <p>This method starts downloading the attachment at the specified index in the current email.
     * The download happens in the background. This method returns immediately after starting the
     * download and does not wait for the download to complete.
     *
     * @param index The index of the attachment to download
     */
    public void downloadAttachment(int index);

    /**
     * Setup expectations: Gmail is open and an email is open.
     *
     * <p>This method gets every link target in an open email by traversing the UI tree of the body
     * of the open message.
     *
     * @return an iterator over the links in the message
     */
    public List<String> getEmailLinks();

    /**
     * Setup expectations: Gmail is open and an email is open.
     *
     * <p>This method clicks the link in the open email with the given target.
     *
     * @param target the target of the link to click
     */
    public void openEmailLink(String target);

    /**
     * Setup expectations: Gmail is open on any page that has a search bar on top.
     *
     * @param searchString string to search for in all emails
     */
    public void search(String searchString);

    /**
     * Setup expectations: Gmail is open and an email is open.
     *
     * <p>This method clicks the delete icon in an open email.
     */
    public void deleteCurrentEmail();

    /**
     * Setup expectations: Gmail is open and an email is open.
     *
     * <p>This method swipes the current email.
     *
     * @param direction The direction to swipe, only accepts LEFT and RIGHT.
     */
    public default void swipeEmail(Direction direction) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    /**
     * Setup expectations: Gmail is open and a mailbox is open.
     *
     * <p>This method open account menu.
     */
    public default void openAccountMenu() {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    /**
     * Setup expectations: Gmail mailbox is open.
     *
     * <p>The UiObject2 for Gmail to get mail contents container view.
     */
    public UiObject2 getGmailContentsContainer();

    /**
     * Setup expectations: Gmail primary mail is open.
     *
     * <p>This method will check if the current view is the email contents page.
     */
    public boolean isOnGmailContentsPage();

    /**
     * Setup expectation: Gmail is open.
     *
     * <p>Get the UiObject2 of mail button icon.
     */
    public UiObject2 getMailButton();

    /**
     * Setup expectation: Gmail is open.
     *
     * <p>This method will click mail button and go to the top of the mail list.
     */
    public void backToTopByMailButton();

    /**
     * Setup expectation: Gmail is open.
     *
     * <p>This method will switch mail label and go to the top of the mail list.
     */
    public void backToTopBySwitchLabel();

    /**
     * Setup expectations: Gmail mailbox is open.
     *
     * <p>This method will get a UiObject2 object for Gmail list container.
     */
    public UiObject2 getGmailListContainer();

    /**
     * Setup expectation: Gmail is open and emails are download completed.
     *
     * <p>This method will check if the current view is on Gmail list page.
     */
    public boolean isOnGmailListPage();
}
