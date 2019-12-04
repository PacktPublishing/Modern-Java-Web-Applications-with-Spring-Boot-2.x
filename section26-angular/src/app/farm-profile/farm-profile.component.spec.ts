import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FarmProfileComponent } from './farm-profile.component';

describe('FarmProfileComponent', () => {
  let component: FarmProfileComponent;
  let fixture: ComponentFixture<FarmProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FarmProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FarmProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
