import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FarmUsersComponent } from './farm-users.component';

describe('FarmUsersComponent', () => {
  let component: FarmUsersComponent;
  let fixture: ComponentFixture<FarmUsersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FarmUsersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FarmUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
