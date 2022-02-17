import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReasonForRejectionComponent } from './reason-for-rejection.component';

describe('ReasonForRejectionComponent', () => {
  let component: ReasonForRejectionComponent;
  let fixture: ComponentFixture<ReasonForRejectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReasonForRejectionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReasonForRejectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
