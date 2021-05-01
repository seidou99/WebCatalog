import 'zone.js/dist/zone-testing';
import '@nativescript/zone-js';
import {browser, logging} from 'protractor';
import {AppPage} from './app.po';
import {TestBed} from "@angular/core/testing";
import {AppNewPhoneModelComponent} from "../../src/app/components/new-phone-model/app-new-phone-model.component";

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should create phone model', async () => {
    const fixture = TestBed.createComponent(AppNewPhoneModelComponent);
    const newPhoneModelComponent = fixture.componentInstance;
    await createAndCheckManufacturer(newPhoneModelComponent);
    const s = '';
  });

  async function createAndCheckManufacturer(component: AppNewPhoneModelComponent): Promise<void> {
    await component.createNewManufacturer();
  }

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
