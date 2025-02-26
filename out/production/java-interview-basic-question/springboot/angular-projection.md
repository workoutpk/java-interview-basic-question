I'll provide a comprehensive example of content projection in Angular using multiple projection techniques.

### Content Projection Example

I'll create a comprehensive example that demonstrates different types of content projection:
1. Single Slot Projection
2. Multiple Slot Projection
3. Conditional Projection



```typescript
// card.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-card',
  template: `
    <div class="card">
      <div class="card-header">
        <ng-content select="[header]"></ng-content>
      </div>
      <div class="card-body">
        <ng-content></ng-content>
      </div>
      <div class="card-footer">
        <ng-content select="[footer]"></ng-content>
      </div>
    </div>
  `,
  styles: [`
    .card {
      border: 1px solid #ddd;
      border-radius: 4px;
      max-width: 300px;
      margin: 10px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }
    .card-header, .card-body, .card-footer {
      padding: 10px;
    }
    .card-header {
      background-color: #f4f4f4;
      border-bottom: 1px solid #ddd;
    }
    .card-footer {
      background-color: #f4f4f4;
      border-top: 1px solid #ddd;
    }
  `]
})
export class CardComponent {}

// app.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <div class="container">
      <h2>Content Projection Demos</h2>
      
      <!-- Single Slot Projection -->
      <app-card>
        <p>This is a simple card with default content projection.</p>
      </app-card>

      <!-- Multiple Slot Projection -->
      <app-card>
        <h3 header>Custom Header</h3>
        <p>This card has a custom header and body content.</p>
        <div footer>Custom Footer</div>
      </app-card>

      <!-- Conditional Projection -->
      <app-expandable-panel>
        <ng-container *ngIf="showContent">
          <p>This content is conditionally projected!</p>
        </ng-container>
      </app-expandable-panel>

      <button (click)="toggleContent()">
        {{ showContent ? 'Hide' : 'Show' }} Content
      </button>
    </div>
  `
})
export class AppComponent {
  showContent = false;

  toggleContent() {
    this.showContent = !this.showContent;
  }
}

// expandable-panel.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-expandable-panel',
  template: `
    <div class="expandable-panel">
      <div class="panel-content">
        <ng-content></ng-content>
      </div>
    </div>
  `,
  styles: [`
    .expandable-panel {
      border: 1px solid #ddd;
      margin: 10px;
      padding: 10px;
    }
  `]
})
export class ExpandablePanelComponent {}

// app.module.ts
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    ExpandablePanelComponent
  ],
  imports: [
    BrowserModule,
    CommonModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

```

### Key Concepts Demonstrated

1. **Single Slot Projection**
    - The default `<ng-content>` without a selector
    - Projecting simple content into a card component

2. **Multiple Slot Projection**
    - Using `select` attribute with `ng-content`
    - Projecting different content into header, body, and footer

3. **Conditional Projection**
    - Using `*ngIf` to conditionally show/hide projected content
    - Demonstrating dynamic content projection

### Breakdown of Content Projection Techniques

#### Single Slot Projection
```typescript
<ng-content></ng-content>
// Projects any content without specific selectors
```

#### Multiple Slot Projection
```typescript
<ng-content select="[header]"></ng-content>
<ng-content select="[footer]"></ng-content>
// Projects content to specific slots using attribute selectors
```

#### Conditional Projection
```typescript
<ng-container *ngIf="showContent">
  <!-- Content shown/hidden based on condition -->
</ng-container>
```

### Best Practices
- Use content projection to create reusable, flexible components
- Leverage attribute selectors for precise content placement
- Combine with structural directives for dynamic content

### Common Use Cases
- Creating wrapper components
- Building flexible UI components
- Implementing component composition

Would you like me to elaborate on any of these content projection techniques or explain how they can be applied in more complex scenarios?