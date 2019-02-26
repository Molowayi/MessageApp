import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListmessagesComponent } from './listmessages.component';

describe('ListmessagesComponent', () => {
  let component: ListmessagesComponent;
  let fixture: ComponentFixture<ListmessagesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListmessagesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListmessagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
